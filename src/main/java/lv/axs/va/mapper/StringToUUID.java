package lv.axs.va.mapper;

import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public interface StringToUUID {
    default UUID stringToUUID(String uuid) {
        if (null == uuid || uuid.isEmpty()) return UUID.randomUUID();
        return UUID.fromString(uuid);
    }

    default String uuidToString(UUID uuid) {
        if (null == uuid) return UUID.randomUUID().toString();
        return uuid.toString();
    }
}
