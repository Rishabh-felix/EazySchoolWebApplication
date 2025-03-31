package com.eazybytes.eazyschool.service;
import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if(savedContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> getContactList(String status){
        return contactRepository.findByStatus(status);
    }

    public boolean updateStatus(int contactId){
        boolean isUpdated = false;

        Optional<Contact> contact = contactRepository.findById(contactId);

        contact.ifPresent((contact1 -> {
            contact1.setStatus(EazySchoolConstants.CLOSE);
        }));

        Contact updatedContact = contactRepository.save(contact.get());

        if(updatedContact.getUpdatedBy() != null){
            isUpdated=true;
        }
        return isUpdated;
    }
}
