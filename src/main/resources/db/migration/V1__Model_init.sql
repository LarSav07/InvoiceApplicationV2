create table account
(
    account_id bigint not null
        primary key,
    bic        bigint,
    bank_name  varchar(255),
    iban       bigint
);

alter table account
    owner to postgres;

create table account_holder
(
    account_holderid bigint not null
        primary key,
    address_line1    varchar(255),
    address_line2    varchar(255),
    city             varchar(255),
    company_name     varchar(255),
    country          varchar(255),
    customer_number  bigint,
    our_reference    varchar(255),
    post_code        varchar(255),
    your_reference   varchar(255),
    account_id       bigint
        constraint fkn4212xs4wsfh8cfj9rddju6ic
            references account
);

alter table account_holder
    owner to postgres;

create table invoice
(
    invoice_number  bigint       not null
        primary key,
    company_address varchar(255),
    company_name    varchar(255),
    email_address   varchar(255) not null
);

alter table invoice
    owner to postgres;

create table payment
(
    invoice_number bigint           not null
        primary key,
    ocr            bigint,
    amount         double precision not null,
    amount_inc_tax double precision not null,
    creditor       varchar(255),
    debtor         varchar(255),
    interest       double precision not null,
    status_id      bigint,
    tax            double precision not null
);

alter table payment
    owner to postgres;

create table payment_status
(
    payment_statusid bigint not null
        primary key,
    status           varchar(255),
    invoice_number   bigint
        constraint fk7nghs1j7w225g0i6akm3e7pr6
            references payment
);

alter table payment_status
    owner to postgres;

