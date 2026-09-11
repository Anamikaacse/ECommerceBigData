data = LOAD '/ecommerce/input/ecommerce_dataset_+1m.csv' USING PigStorage(',') AS (
    order_id:chararray, order_date:chararray, order_year:int, order_month:int, order_day:int,
    order_hour:int, order_minute:int, order_second:int, is_weekend:chararray, order_status:chararray,
    return_reason:chararray, customer_id:chararray, customer_name:chararray, gender:chararray, age:int,
    customer_segment:chararray, country:chararray, city:chararray, customer_loyalty_score:double,
    total_orders_by_customer:int, account_creation_date:chararray, product_id:chararray, product_name:chararray,
    category:chararray, sub_category:chararray, brand:chararray, product_rating_avg:double, product_reviews_count:int,
    stock_quantity:int, unit_price_usd:double, quantity:int, discount_percent:double, discount_amount_usd:double,
    total_price_usd:double, cost_usd:double, profit_usd:double, tax_usd:double, currency:chararray,
    payment_method:chararray, payment_status:chararray, installment_plan:chararray, shipping_method:chararray,
    shipping_cost_usd:double, delivery_days:int, shipping_country:chararray, warehouse_location:chararray,
    delivery_status:chararray, rating:double, review_sentiment:chararray, customer_feedback:chararray,
    coupon_used:chararray, coupon_code:chararray, campaign_source:chararray, device_type:chararray,
    traffic_source:chararray, session_duration_minutes:double, pages_visited:int, abandoned_cart_before:chararray,
    fraud_risk_score:double, profit_margin_percent:double, order_priority:chararray, support_ticket_created:chararray
);

clean = FILTER data BY order_id IS NOT NULL AND order_id != 'order_id' AND total_price_usd IS NOT NULL;

grouped = GROUP clean BY product_name;
product_qty = FOREACH grouped GENERATE group AS product_name, SUM(clean.quantity) AS total_quantity;
product_sorted = ORDER product_qty BY total_quantity DESC;
top10_products = LIMIT product_sorted 10;
STORE top10_products INTO '/ecommerce/output/pig/Top10BestSellingProductsPig' USING PigStorage(',');