package com.invoice.service;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;
import com.invoice.exceptions.InvoiceNotFoundException;
import com.invoice.repository.AccountHolderRepository;
import com.invoice.repository.AccountRepository;
import com.invoice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserInputServiceImpl implements UserInputService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public AccountHolder saveAccount(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    @Override
    public Contact saveAccount(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Account> fetchAccountsList() {
        return accountRepository.findAll();
    }

    @Override
    public List<AccountHolder> fetchAccountHoldersList() {
        return accountHolderRepository.findAll();
    }

    @Override
    public List<Contact> fetchContactsList() {
        return contactRepository.findAll();
    }

    @Override
    public Account fetchAccountByAccountId(Long accountId) throws InvoiceNotFoundException {
        Optional<Account> account =
                accountRepository.findById(accountId);
        if (!account.isPresent()) {
            throw new InvoiceNotFoundException("Account not Found");
        }
        return account.get();
    }

    @Override
    public AccountHolder fetchAccountHolderByAccountHolderId(Long accountHolderId) throws InvoiceNotFoundException {
        Optional<AccountHolder> accountHolder =
                accountHolderRepository.findById(accountHolderId);
        if (!accountHolder.isPresent()) {
            throw new InvoiceNotFoundException("AccountHolder not Found");
        }
        return accountHolder.get();
    }
    @Override
    public Contact fetchContactByContactId(Long contactId) throws InvoiceNotFoundException {
        Optional<Contact> contact =
                contactRepository.findById(contactId);
        if (!contact.isPresent()) {
            throw new InvoiceNotFoundException("Contact not Found");
        }
        return contact.get();
    }
    @Override
    public void deleteAccountByAccountId(Long accountId) {
        accountRepository.deleteById(accountId);
    }
    @Override
    public void deleteAccountHolderByAccountHolderId(Long accountHolderId) {
        accountHolderRepository.deleteById(accountHolderId);
    }
    @Override
    public void deleteContactByContactId(Long contactId) {
        contactRepository.deleteById(contactId);
    }

    @Override
    public Account updateAccount(Long accountId, Account account) {
        Account depDB = accountRepository.findById(accountId).get();
        if(Objects.nonNull(account.getBankName()) && !"".equalsIgnoreCase(account.getBankName()))
        {
            depDB.setBankName(account.getBankName());
        }
        if(Objects.nonNull(account.getBic()))
        {
            depDB.setBic(account.getBic());
        }
        if(Objects.nonNull(account.getIban()))
        {
            depDB.setIban(account.getIban());
        }
        return accountRepository.save(depDB);
    }

    @Override
    public Contact updateContact(Long contactId, Contact contact) {
        Contact depDB = contactRepository.findById(contactId).get();
        if(Objects.nonNull(contact.getContactName()) && !"".equalsIgnoreCase(contact.getContactName()))
        {
            depDB.setContactName(contact.getContactName());
        }
        if(Objects.nonNull(contact.getContactNumber()) && !"".equalsIgnoreCase(contact.getContactNumber()))
        {
            depDB.setContactNumber(contact.getContactNumber());
        }
        if(Objects.nonNull(contact.getEmailAddress()) && !"".equalsIgnoreCase(contact.getEmailAddress()))
        {
            depDB.setEmailAddress(contact.getEmailAddress());
        }
        if(Objects.nonNull(contact.getAddressLine1()) && !"".equalsIgnoreCase(contact.getAddressLine1()))
        {
            depDB.setAddressLine1(contact.getAddressLine1());
        }
        if(Objects.nonNull(contact.getAddressLine2()) && !"".equalsIgnoreCase(contact.getAddressLine2()))
        {
            depDB.setAddressLine2(contact.getAddressLine2());
        }
        if(Objects.nonNull(contact.getCity()) && !"".equalsIgnoreCase(contact.getCity()))
        {
            depDB.setCity(contact.getCity());
        }
        if(Objects.nonNull(contact.getCountry()) && !"".equalsIgnoreCase(contact.getCountry()))
        {
            depDB.setCountry(contact.getCountry());
        }
        if(Objects.nonNull(contact.getPostCode()) && !"".equalsIgnoreCase(contact.getPostCode()))
        {
            depDB.setPostCode(contact.getPostCode());
        }
        return contactRepository.save(depDB);
    }
    @Override
    public AccountHolder updateAccountHolder(Long accountHolderId, AccountHolder accountHolder) {
        AccountHolder depDB = accountHolderRepository.findById(accountHolderId).get();
        if (Objects.nonNull(accountHolder.getCompanyName()) && !"".equalsIgnoreCase(accountHolder.getCompanyName())) {
            depDB.setCompanyName(accountHolder.getCompanyName());
        }
        if (Objects.nonNull(accountHolder.getCustomerNumber())) {
            depDB.setCustomerNumber(accountHolder.getCustomerNumber());
        }
        return accountHolderRepository.save(depDB);
    }

    @Override
    public AccountHolder fetchInvoiceByCompanyName(String companyName) {
        return accountHolderRepository.findByCompanyNameIgnoreCase(companyName);
    }
}
