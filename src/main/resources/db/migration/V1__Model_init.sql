CREATE SEQUENCE IF NOT EXISTS account_holderid_sequence START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS account_id_sequence START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS invoice_number_sequence START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS payment_status_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE account
(
    account_id BIGINT NOT NULL,
    bic        BIGINT,
    iban       BIGINT,
    bank_name  VARCHAR(255),
    CONSTRAINT pk_account PRIMARY KEY (account_id)
);

CREATE TABLE account_holder
(
    account_holderid BIGINT NOT NULL,
    company_name     VARCHAR(255),
    customer_number  BIGINT,
    our_reference    VARCHAR(255),
    your_reference   VARCHAR(255),
    address_line1    VARCHAR(255),
    address_line2    VARCHAR(255),
    post_code        VARCHAR(255),
    city             VARCHAR(255),
    country          VARCHAR(255),
    account_id       BIGINT,
    CONSTRAINT pk_accountholder PRIMARY KEY (account_holderid)
);

CREATE TABLE invoice
(
    invoice_number  BIGINT NOT NULL,
    company_name    VARCHAR(255),
    company_address VARCHAR(255),
    email_address   VARCHAR(255),
    CONSTRAINT pk_invoice PRIMARY KEY (invoice_number)
);

CREATE TABLE payment
(
    invoice_number BIGINT NOT NULL,
    debtor         VARCHAR(255),
    creditor       VARCHAR(255),
    amount         DOUBLE PRECISION,
    amount_inc_tax DOUBLE PRECISION,
    tax            DOUBLE PRECISION,
    interest       DOUBLE PRECISION,
    ocr            BIGINT,
    status_id      BIGINT,
    CONSTRAINT pk_payment PRIMARY KEY (invoice_number)
);

CREATE TABLE payment_status
(
    payment_statusid BIGINT NOT NULL,
    status           VARCHAR(255),
    invoice_number   BIGINT,
    CONSTRAINT pk_paymentstatus PRIMARY KEY (payment_statusid)
);

ALTER TABLE account_holder
    ADD CONSTRAINT FK_ACCOUNTHOLDER_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES account (account_id);

ALTER TABLE payment_status
    ADD CONSTRAINT FK_PAYMENTSTATUS_ON_INVOICE_NUMBER FOREIGN KEY (invoice_number) REFERENCES payment (invoice_number);