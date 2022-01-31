insert into gift_certificate (name, description, price, duration, create_date, last_update_date) values
('name', 'desc', 123.0, 3454, now(), now());

insert into gift_certificate (name, description, price, duration, create_date, last_update_date) values
    ('Certificate', 'Sample text', 123.0, 3454, now(), now());

insert into gift_certificate (name, description, price, duration, create_date, last_update_date) values
    ('Car certificate', 'Free car', 125.0, 345, now(), now());

insert into gift_certificate (name, description, price, duration, create_date, last_update_date) values
    ('Museum certificate', '25% sale', 435.0, 23, now(), now());

insert into tag (name)
values ('Health');

insert into tag (name)
values ('Cars');

insert into tag (name)
values ('Leisure');

insert into tag (name)
values ('Culture');

insert into certificate_tags (certificate_id, tag_id)
values (1, 1), (1, 4), (2, 2), (3, 2), (3, 1), (4, 3), (4, 4);