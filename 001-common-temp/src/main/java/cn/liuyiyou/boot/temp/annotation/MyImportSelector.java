package cn.liuyiyou.boot.temp.annotation;

import java.util.function.Predicate;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/1
 * @version: V1.0
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(final AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }
}
