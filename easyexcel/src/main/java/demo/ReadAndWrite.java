package demo;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 读写
 *
 * @version 1.0 2019-08-11
 */
public class ReadAndWrite {

    private static final AtomicInteger rowCount = new AtomicInteger(0);
    private static final AtomicInteger sheetCount = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        final Map<String, List<String[]>> idToSplit = Files
                .lines(Paths.get("/Users/zenuo/data/merged"))
                .filter(line -> !line.isEmpty())
                .map(ReadAndWrite::split)
                .collect(Collectors.groupingBy(split -> split[3], TreeMap::new, Collectors.toList()));
        System.out.println("映射体积" + idToSplit.size());
        write(idToSplit);
        System.out.println("共写入" + sheetCount.get() + " sheets, " + rowCount.get() + " rows.");
    }

    private static String[] split(String line) {
        final String[] split = line.split(",", -1);
        return Arrays.copyOfRange(split, 1, split.length);
    }

    private static void write(Map<String, List<String[]>> map) throws IOException {
        try (OutputStream out = new FileOutputStream("/Users/zenuo/data/result.xlsx", false)) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            final AtomicInteger counter = new AtomicInteger();
            map.forEach((k, v) -> write(writer, counter.getAndIncrement(), k, v));
            writer.finish();
        }
    }

    private static void write(ExcelWriter writer, int sheetNo, String id, List<String[]> lines) {
        sheetCount.getAndIncrement();

        Sheet sheet = new Sheet(sheetNo, 0, ExcelPropertyIndexModel.class, id, Collections.emptyList());
        final AtomicInteger row = new AtomicInteger(1);
        final List<ExcelPropertyIndexModel> list = lines.stream().map(line -> of(row.getAndIncrement(), line)).collect(Collectors.toList());
        writer.write(list, sheet);
    }

    private static ExcelPropertyIndexModel of(Integer row, String[] line) {
        rowCount.getAndIncrement();

        final ExcelPropertyIndexModel model = new ExcelPropertyIndexModel();
        model.setRow(row);
        model.setId(line[0]);
        model.setName(line[1]);
        model.setType(line[2]);
        model.setCommunityId(line[3]);
        model.setCommunityName(line[4]);
        model.setSerial(line[5]);
        return model;
    }
}
