DROP TABLE IF EXISTS gift_certificate;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS certificate_tags;

CREATE TABLE tag
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    name   varchar(50) NOT NULL UNIQUE
);

CREATE TABLE gift_certificate
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    name             varchar(100)   NOT NULL,
    description      varchar(100)          NOT NULL,
    price            decimal(10, 2) NOT NULL,
    create_date      timestamp   NOT NULL,
    last_update_date timestamp   NOT NULL,
    duration         integer       NOT NULL

);

CREATE TABLE certificate_tags
(
    certificate_id INT NOT NULL,
    tag_id  INT NOT NULL,
    CONSTRAINT FK_gift_certificate_tag_tagId FOREIGN KEY (tag_id)
        REFERENCES tag (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_gift_certificate_tag_gift_certificate_id FOREIGN KEY (certificate_id)
        REFERENCES gift_certificate (id) ON DELETE CASCADE ON UPDATE CASCADE
);