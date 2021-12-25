package com.epam.esm.dao;

public final class CertificateQuery {

    public static final String SQL_FIND_ALL =
            "select id, name, description, price, duration, create_date, last_update_date from gift_certificate;";

    public static final String SQL_FIND_ID =
            "select name, description, price, duration, create_date, last_update_date " +
                    "from gift_certificate where id = ?;";

    public static final String SQL_CREATE =
            "insert into gift_certificate (name, description, price, duration, create_date, last_update_date) " +
                    "values (?, ?, ?, ?, ?, ?);";

    public static final String SQL_UPDATE =
            "update gift_certificate set name = ?, description = ?, price = ?, " +
                    "duration = ?, create_date = ?, last_update_date = ? where id = ?;";

    public static final String SQL_DELETE =
            "delete from gift_certificate where id = ?;";

    private CertificateQuery() { }
}
