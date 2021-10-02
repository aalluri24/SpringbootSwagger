package com.sample.springbootswagger2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    ConcurrentHashMap<String,Contact> contacts = new ConcurrentHashMap();

    @PostMapping("/addContact")
    public void addContact(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    @GetMapping("/getAllContacts")
    public List<Contact> getAllContacts() {
        return new ArrayList<Contact>(contacts.values());
    }

    @GetMapping("/getContact/{id}")
    public Contact getContact(@PathVariable String id) {
        return contacts.get(id);
    }
}
