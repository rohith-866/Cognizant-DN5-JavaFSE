CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN accounts.account_id%TYPE,
    p_to_account   IN accounts.account_id%TYPE,
    p_amount       IN NUMBER
) AS
    v_from_balance accounts.balance%TYPE;
    v_to_balance   accounts.balance%TYPE;
BEGIN
    SELECT balance INTO v_from_balance
    FROM accounts
    WHERE account_id = p_from_account;

    SELECT balance INTO v_to_balance
    FROM accounts
    WHERE account_id = p_to_account;

    IF v_from_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Transfer FAILED: Insufficient balance in Account ' || p_from_account);
        DBMS_OUTPUT.PUT_LINE('Available Balance: $' || v_from_balance || ' | Requested: $' || p_amount);
        RETURN;
    END IF;

    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer SUCCESSFUL');
    DBMS_OUTPUT.PUT_LINE('From Account: ' || p_from_account ||
                         ' | Old Balance: $' || v_from_balance ||
                         ' | New Balance: $' || (v_from_balance - p_amount));
    DBMS_OUTPUT.PUT_LINE('To Account  : ' || p_to_account ||
                         ' | Old Balance: $' || v_to_balance ||
                         ' | New Balance: $' || (v_to_balance + p_amount));
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFunds;
/

BEGIN
    TransferFunds(p_from_account => 1001, p_to_account => 1002, p_amount => 500);
END;
/
