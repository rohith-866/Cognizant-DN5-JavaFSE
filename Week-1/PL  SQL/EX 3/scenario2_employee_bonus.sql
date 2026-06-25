CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id IN employees.department_id%TYPE,
    p_bonus_percent IN NUMBER
) AS
    CURSOR c_employees IS
        SELECT employee_id, employee_name, salary
        FROM employees
        WHERE department_id = p_department_id;

    v_employee_id   employees.employee_id%TYPE;
    v_employee_name employees.employee_name%TYPE;
    v_salary        employees.salary%TYPE;
    v_bonus         NUMBER;
BEGIN
    OPEN c_employees;
    LOOP
        FETCH c_employees INTO v_employee_id, v_employee_name, v_salary;
        EXIT WHEN c_employees%NOTFOUND;

        v_bonus := v_salary * (p_bonus_percent / 100);

        UPDATE employees
        SET salary = salary + v_bonus
        WHERE employee_id = v_employee_id;

        DBMS_OUTPUT.PUT_LINE('Employee ID: ' || v_employee_id ||
                             ' | Name: ' || v_employee_name ||
                             ' | Old Salary: $' || v_salary ||
                             ' | Bonus: $' || v_bonus ||
                             ' | New Salary: $' || (v_salary + v_bonus));
    END LOOP;
    CLOSE c_employees;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus updated for Department ID: ' || p_department_id);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateEmployeeBonus;
/

BEGIN
    UpdateEmployeeBonus(p_department_id => 10, p_bonus_percent => 15);
END;
/
