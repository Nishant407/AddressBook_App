package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressBookDTO;
import com.example.AddressBook.exceptions.AddressBookException;
import com.example.AddressBook.model.AddressBook;
import com.example.AddressBook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServiceImpl implements IAddressBookService {
    @Autowired
    private AddressBookRepository repository;

    @Override
    public AddressBook addEntry(AddressBookDTO dto) {
        AddressBook entry = new AddressBook();
        entry.setName(dto.getName());
        entry.setAddress(dto.getAddress());
        entry.setPhoneNumber(dto.getPhoneNumber());
        return repository.save(entry);
    }

    @Override
    public List<AddressBook> getAllEntries() {
        return repository.findAll();
    }

    @Override
    public AddressBook getEntryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AddressBookException("Entry not found"));
    }

    @Override
    public AddressBook updateEntry(Long id, AddressBookDTO dto) {
        AddressBook entry = getEntryById(id);
        entry.setName(dto.getName());
        entry.setAddress(dto.getAddress());
        entry.setPhoneNumber(dto.getPhoneNumber());
        return repository.save(entry);
    }

    @Override
    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }

    public void test(){};
}