package com.sample.springbootswagger2;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    ConcurrentHashMap<String,Contact> contacts = new ConcurrentHashMap();

    @PostMapping("/addContact")
    @ApiOperation(value = "Add contact to an address book",
        notes ="Pass a JSON body with Contact Info to add to the address book")
    public void addContact(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    @GetMapping("/getAllContacts")
    @ApiOperation(value = "Finds all contacts",
            notes = "Returns all contacts from the address book",
            response = Contact.class)
    public List<Contact> getAllContacts() {
        return new ArrayList<Contact>(contacts.values());
    }

    @GetMapping("/getContact/{id}")
    @ApiOperation(value = "Finds contacts by id",
        notes = "Provide an id to look-up specific contact from the address book",
        response = Contact.class)
    public Contact getContact(@ApiParam(value = "ID value for the contact you need to retrieve", required = true)
            @PathVariable String id) {
        return contacts.get(id);
    }
}
