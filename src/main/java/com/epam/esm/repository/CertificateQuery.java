package com.epam.esm.repository;

public final class CertificateQuery {

    public static final String SQL_FIND_ALL =
            "SELECT DISTINCT gift_certificate.id," +
                    "                gift_certificate.name, " +
                    "                gift_certificate.description, " +
                    "                gift_certificate.price, " +
                    "                gift_certificate.create_date, " +
                    "                gift_certificate.last_update_date, " +
                    "                gift_certificate.duration " +
                    "from gift_certificate" +
                    "         JOIN certificate_tags ct on gift_certificate.id = ct.certificate_id " +
                    "         JOIN tag ON ct.tag_id = tag.id " +
                    "WHERE 1 = 1 ";

    public static final String SQL_FIND_BY_TAG_NAME =
            "select gift_certificate.id, gift_certificate.name, description, price, duration, " +
                    "create_date, last_update_date, t.name from gift_certificate " +
                    "left join certificate_tags ct on gift_certificate.id = ct.certificate_id " +
                    "left join tag t on ct.tag_id = t.id " +
                    "where t.name = ? ";

    public static final String SQL_FIND_ID =
            "select id, name, description, price, duration, create_date, last_update_date " +
                    "from gift_certificate where id = ?;";

    public static final String SQL_UPDATE =
            "update gift_certificate set name = coalesce(?, name), description = coalesce(?, description), " +
                    "price = coalesce(?, price), duration = coalesce(?, duration), last_update_date = ? where id = ?;";

    public static final String SQL_DELETE =
            "delete from gift_certificate where id = ?;";

    private CertificateQuery() {
    }
}
