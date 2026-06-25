DECLARE
    CURSOR c_customers IS
        SELECT customer_id, customer_name, balance
        FROM customers;

    v_customer_id   customers.customer_id%TYPE;
    v_customer_name customers.customer_name%TYPE;
    v_balance       customers.balance%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer_id, v_customer_name, v_balance;
        EXIT WHEN c_customers%NOTFOUND;

        IF v_balance > 10000 THEN
            UPDATE customers
            SET isvip = TRUE
            WHERE customer_id = v_customer_id;

            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id ||
                                 ' | Name: ' || v_customer_name ||
                                 ' | Balance: $' || v_balance ||
                                 ' | Status: VIP');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id ||
                                 ' | Name: ' || v_customer_name ||
                                 ' | Balance: $' || v_balance ||
                                 ' | Status: Regular');
        END IF;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');
END;
/
