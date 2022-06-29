package com.l3azh.management.SpendingManagement.Services;

import com.l3azh.management.SpendingManagement.DAOS.ITransTypeDao;
import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.Entities.TransTypeEntity;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransTypeFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.TransTypeWithNameAlreadyExistInDbException;
import com.l3azh.management.SpendingManagement.Repositories.ITransTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransTypeService implements ITransTypeDao {

    private final ITransTypeRepository iTransTypeRepository;

    @Override
    @Transactional
    public BaseResponseDto<CreateTransTypeResponseDto> createNewTransType(CreateTransTypeRequestDto requestDto)
            throws TransTypeWithNameAlreadyExistInDbException {
        Optional<List<TransTypeEntity>> listTransTypeResultObject =
                iTransTypeRepository.getListTransTypeByName(requestDto.getName());
        if (listTransTypeResultObject.isPresent()) {
            if (listTransTypeResultObject.get().size() > 0) {
                throw new TransTypeWithNameAlreadyExistInDbException("TransType with this name already exist in db");
            }
        }
        TransTypeEntity newTransType = TransTypeEntity.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription()).build();
        iTransTypeRepository.save(newTransType);
        return BaseResponseDto.<CreateTransTypeResponseDto>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(CreateTransTypeResponseDto.builder().message("Create new trans type successful !").build())
                .build();
    }

    @Override
    @Transactional
    public BaseResponseDto<UpdateTransTypeResponseDto> updateTransType(String uuidTransType, UpdateTransTypeRequestDto requestDto)
            throws NoneTransTypeFoundWithUUIDException, TransTypeWithNameAlreadyExistInDbException {
        Optional<TransTypeEntity> transTypeResultObject = iTransTypeRepository.findById(UUID.fromString(uuidTransType));
        if (transTypeResultObject.isEmpty()) {
            throw new NoneTransTypeFoundWithUUIDException("Can not find any trans type with this uuid: " + uuidTransType);
        }
        TransTypeEntity updateTransType = transTypeResultObject.get();
        Optional<List<TransTypeEntity>> listTransTypeResultObject =
                iTransTypeRepository.getListTransTypeByName(requestDto.getName());
        if (listTransTypeResultObject.isPresent()) {
            if (listTransTypeResultObject.get().size() > 0) {
                throw new TransTypeWithNameAlreadyExistInDbException("TransType with this name already exist in db");
            }
        }
        updateTransType.setName(requestDto.getName());
        updateTransType.setDescription(requestDto.getDescription());
        iTransTypeRepository.save(updateTransType);
        return BaseResponseDto.<UpdateTransTypeResponseDto>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(UpdateTransTypeResponseDto.builder().message("Update new trans type successful !").build())
                .build();
    }
}
