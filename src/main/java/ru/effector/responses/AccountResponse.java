package ru.effector.responses;

import ru.effector.model.Account;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class AccountResponse extends PageableResponse {

    public List<Account> accounts;

}
