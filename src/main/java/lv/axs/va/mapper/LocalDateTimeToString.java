package lv.axs.va.mapper;

import org.mapstruct.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface LocalDateTimeToString {
    default LocalDateTime stringToLocalDateTime(String str) {
        if (str == null) return null;
        else return LocalDateTime.parse(str);
    }

    default String localDateTimeToString(LocalDateTime str) {
        if (str == null) return null;
        else return str.toString();
    }
}
