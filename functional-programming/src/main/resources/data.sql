INSERT INTO CategoryCustomer (idCategoryCustomer, description,state) VALUES (1, 'personal','CREATED');
INSERT INTO CategoryCustomer (idCategoryCustomer, description,state) VALUES (2, 'empresarial','CREATED');

INSERT INTO customers (idCustomer,firstNameCustomer,lastNameCustomer , dniCustomer, emailCustomer,CategoryCustomer, state) VALUES(1,'Rex', 'Steven', '11223344', 'rexstev@email.com','',1,'CREATED');
