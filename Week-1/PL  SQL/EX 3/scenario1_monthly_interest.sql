CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    CURSOR c_savings IS
        SELECT account_id, balance
        FROM accounts
        WHERE account_type = 'SAVINGS';

    v_account_id accounts.account_id%TYPE;
    v_balance    accounts.balance%TYPE;
    v_interest   NUMBER;
BEGIN
    OPEN c_savings;
    LOOP
        FETCH c_savings INTO v_account_id, v_balance;
        EXIT WHEN c_savings%NOTFOUND;

        v_interest := v_balance * 0.01;

        UPDATE accounts
        SET balance = balance + v_interest
        WHERE account_id = v_account_id;

        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id ||
                             ' | Old Balance: $' || v_balance ||
                             ' | Interest Added: $' || v_interest ||
                             ' | New Balance: $' || (v_balance + v_interest));
    END LOOP;
    CLOSE c_savings;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END ProcessMonthlyInterest;
/

BEGIN
    ProcessMonthlyInterest;
END;
/
