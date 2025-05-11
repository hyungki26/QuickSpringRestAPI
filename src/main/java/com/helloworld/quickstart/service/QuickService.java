package com.helloworld.quickstart.service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.entity.ItemEntity;
import com.helloworld.quickstart.mapper.QuickMapper;
import com.helloworld.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class QuickService {

    @Autowired
    private QuickMapper quickMapper;

    @Autowired
    private ItemRepository itemRepository;

    public boolean regsterItem(ItemDto itemDto) {
//
//        // TODO DB insert
//        HashMap<String, Object> paramMap = new HashMap<>();
//
//        paramMap.put("name", itemDto.getName());
//        paramMap.put("id", itemDto.getId());
//
//        quickMapper.registerItem(paramMap);
//
//        log.info("regsterItem");
//
//
//        return true;

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

        return true;
    }

    public ItemDto getItemById(String id) {
//
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//
//        HashMap<String, Object> res =  quickMapper.findById(paramMap);
//
//        ItemDto itemDto = new ItemDto();
//
//        itemDto.setId((String)res.get("ID"));
//        itemDto.setName((String)res.get("NAME"));
//
//        return itemDto;

        if (id == null || id.isEmpty()) {

            ItemEntity item = itemRepository.findById(id).get();

            ItemDto itemDto = new ItemDto();

            itemDto.setId(item.getId());
            itemDto.setName(item.getName());

            return itemDto;
        }

        return null;

    }
}
