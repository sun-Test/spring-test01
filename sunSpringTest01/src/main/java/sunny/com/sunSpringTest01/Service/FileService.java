package sunny.com.sunSpringTest01.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Service
@Slf4j
public class FileService {

    public Optional<File[]> getDirFilesWithRegexName(String dir, String regexName) {
        FilenameFilter filter = (itDir, name) -> Pattern.matches(regexName, name);
        File f = new File(dir);
        return Optional.ofNullable(f.listFiles(filter));
    }

    public void deleteFileIfOlderThan(File file, Integer hours, Boolean access) {
        try {
            BasicFileAttributes attr = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
            FileTime fileTimeLast = access ? attr.lastAccessTime() : attr.lastModifiedTime();
            FileTime fileTimeNow = FileTime.fromMillis(ZonedDateTime.now().toInstant().toEpochMilli());
            System.out.println("last acc: " + fileTimeLast);
            System.out.println(String.format("diff hours: %d", (fileTimeNow.to(TimeUnit.HOURS) - fileTimeLast.to(TimeUnit.HOURS))));
            if ((fileTimeNow.to(TimeUnit.HOURS) - fileTimeLast.to(TimeUnit.HOURS)) > hours) {
                Files.delete(Paths.get(file.getPath()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
