DECLARE
    CURSOR c_loans IS
        SELECT c.customer_id, c.customer_name, l.loan_id, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;

    v_customer_id   customers.customer_id%TYPE;
    v_customer_name customers.customer_name%TYPE;
    v_loan_id       loans.loan_id%TYPE;
    v_due_date      loans.due_date%TYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_customer_id, v_customer_name, v_loan_id, v_due_date;
        EXIT WHEN c_loans%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('REMINDER: Customer ID: ' || v_customer_id ||
                             ' | Name: ' || v_customer_name ||
                             ' | Loan ID: ' || v_loan_id ||
                             ' | Due Date: ' || TO_CHAR(v_due_date, 'DD-MON-YYYY') ||
                             ' | Please repay your loan before the due date.');
    END LOOP;
    CLOSE c_loans;
    DBMS_OUTPUT.PUT_LINE('All reminders printed successfully.');
END;
/
