package me.chinatsui.research.javase;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * Created by chinatsui on 24/02/2018.
 */
public class ExceptionStackTest {

    public static void main(String[] args) {
        System.out.println("select ca.companyid, c.country " +
                "from companyaccounts ca " +
                "inner join companies c on ca.companyid = c.id " +
                "inner join securitygroups sg on c.id = sg.id " +
                "where not exists (select 1 from users u where u.personid = ca.companyid)");
        try {
            new ExceptionStackTest().test();
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
        }
    }

    private void test() {
        throw new RuntimeException("Thrown on purpose");
    }

}
