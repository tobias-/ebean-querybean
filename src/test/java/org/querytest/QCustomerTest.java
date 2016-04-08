package org.querytest;

import com.avaje.ebean.PagedList;
import org.example.domain.Customer;
import org.example.domain.typequery.QContact;
import org.example.domain.typequery.QCustomer;
import org.junit.Test;

import java.util.Date;

public class QCustomerTest {

  @Test
  public void isEmpty() {

    new QCustomer()
        .contacts.isEmpty()
        .findList();

    new QCustomer()
        .contacts.isNotEmpty()
        .findList();
  }

  @Test
  public void setIncludeSoftDeletes() {

    new QCustomer()
        .setIdIn(42L)
        .setIncludeSoftDeletes()
        .findList();
  }

  @Test
  public void testIdIn() {

    new QCustomer()
        .setIdIn("1", "2")
        .findList();

    new QCustomer()
        .id.in(1L, 2L, 3L)
        .findList();
  }

  @Test
  public void testIn() {
    new QCustomer()
        .id.in(34L, 33L)
        .name.in("asd")
        .registered.in(new Date())
        .findList();
  }

  @Test
  public void testQueryBoolean() {

    new QCustomer()
        .name.contains("rob")
        //.setUseDocStore(true)
        .setMaxRows(10)
        .findPagedList();

    new QCustomer()
        .inactive.isFalse()
        .findList();
  }

  @Test
  public void testQuery() {

    QContact contact = QContact.alias();
    QCustomer cust = QCustomer.alias();

    new QCustomer()
        // tune query
        .select(cust.name)
        .contacts.fetchAll()
        // predicates
        .findList();

    new QCustomer()
        // tune query
        .select(cust.id, cust.name)
        .contacts.fetch(contact.firstName, contact.lastName, contact.email)
        // predicates
        .id.greaterThan(1)
        .findList();

    PagedList<Customer> pagedList = new QCustomer()
        // tune query
        .select(cust.id, cust.name)
        .contacts.fetch(contact.firstName, contact.lastName, contact.email)
        // predicates
        .id.greaterThan(1)
        .setFirstRow(20)
        .setMaxRows(10)
        .findPagedList();

    pagedList.getList();
    pagedList.getList();

//    new QCustomer()
//        .asDraft()
//        .findList();
//
//    new QCustomer()
//        .includeSoftDeletes()
//        .findList();

//    List<Contact> contacts
//        = new QContact()
//        .email.like("asd")
//        .notes.title.like("asd")
//        .orderBy()
//          .id.desc()
//        .findList();
//

//    List<Customer> customers = new QCustomer()
//        .id.eq(1234)
//        .status.equalTo(Customer.Status.BAD)
//        .status.in(Customer.Status.GOOD, Customer.Status.MIDDLING)
//            //.status.eq(Order.Status.APPROVED)
//        .name.like("asd")
//        .name.istartsWith("ASdf")
//        .registered.after(new Date())
//        .contacts.email.endsWith("@foo.com")
//        .contacts.notes.id.greaterThan(123L)
//        .orderBy().id.asc()
//        .findList();

//    //Customer customer3 =
//    new QCustomer()
//        .id.gt(12)
//        .or()
//          .id.lt(1234)
//          .and()
//            .name.like("one")
//            .name.like("two")
//          .endAnd()
//        .endOr()
//        .orderBy().id.asc()
//        .findList();
//
//    //where t0.id > ?  and (t0.id < ?  or (t0.name like ?  and t0.name like ? ) )  order by t0.id; --bind(12,1234,one,two)
//
////    List<Customer> customers
////        = new QCustomer()
////          .name.like("asd")
////          .findList();
//
//    Customer.find.where()
//        .gt("id", 1234)
//        .disjunction().eq("id", 1234).like("name", "asd")
//        .endJunction().findList();

//    QCustomer cust = QCustomer.I;
//    ExpressionList<Customer> expr = new QCustomer().expr();
//    expr.eq(cust.contacts.email, 123);
  }
}
