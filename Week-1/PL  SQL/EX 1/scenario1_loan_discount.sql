DECLARE
    CURSOR c_customers IS
        SELECT c.customer_id, c.age, l.loan_id, l.interest_rate
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id;

    v_customer_id customers.customer_id%TYPE;
    v_age         customers.age%TYPE;
    v_loan_id     loans.loan_id%TYPE;
    v_rate        loans.interest_rate%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer_id, v_age, v_loan_id, v_rate;
        EXIT WHEN c_customers%NOTFOUND;

        IF v_age > 60 THEN
            UPDATE loans
            SET interest_rate = interest_rate - 1
            WHERE loan_id = v_loan_id;

            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id ||
                                 ' | Age: ' || v_age ||
                                 ' | Loan ID: ' || v_loan_id ||
                                 ' | Old Rate: ' || v_rate ||
                                 '% | New Rate: ' || (v_rate - 1) || '%');
        END IF;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Discount applied successfully for senior customers.');
END;
/
