package com.example.restful.service;

import com.example.restful.model.Client;
import com.example.restful.repository.ClientRepository;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {
//    // Хранилище клиентов
//    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();
//    // Переменная для генерации ID клиента
//    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

//    @Autowired
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void create(Client client) {
//        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
//        client.setId(clientId);
//        CLIENT_REPOSITORY_MAP.put(clientId, client);

        clientRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
//        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());

        return clientRepository.findAll();
    }

    @Override
    public Client read(int id) {
//        return CLIENT_REPOSITORY_MAP.get(id);

        return clientRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Client client, int id) {
//        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
//            client.setId(id);
//            CLIENT_REPOSITORY_MAP.put(id, client);
//            return true;
//        }
//        return false;

        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
//        return CLIENT_REPOSITORY_MAP.remove(id) != null;

        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
