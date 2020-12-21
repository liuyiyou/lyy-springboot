package cn.liuyiyou.boot.temp;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/15
 * @version: V1.0
 */
public class GrupTest {

    @Test
    void print(){
       String value = "select  a.`name` groupBuyName , a.type type,a.min_num minNum, a.max_num maxNum ,a.start_time startTime, a.end_time endTime ,a.created_time createdTime,a.`status` status,b.product_name productName,a.id id,a.tenant_id tenantId "
            + "from group_buy a left join group_buy_sku b on b.group_buy_id = a.id  where "
            + " if(:#{#groupBuyDTO.tenantId} is null,1=1,a.tenant_id = :#{#groupBuyDTO.tenantId}) and "
            + " if(:#{#groupBuyDTO.name} is null,1=1,a.name like concat('%',:#{#groupBuyDTO.name},'%')) and "
            + " if(:#{#groupBuyDTO.prodName} is null,1=1,b.product_name like concat('%',:#{#groupBuyDTO.prodName},'%')) and "
            + " if(:#{#groupBuyDTO.type} is null,1=1,a.type = :#{#groupBuyDTO.type} ) and "
            + " if(:#{#groupBuyDTO.status} is null,1=1,a.status = :#{#groupBuyDTO.status} ) and "
            + " if(:#{#groupBuyDTO.createdTimeStart} is null,1=1,a.created_time > :#{#groupBuyDTO.createdTimeStart} ) and "
            + " if(:#{#groupBuyDTO.createdTimeEnd} is null,1=1,a.created_time < :#{#groupBuyDTO.createdTimeEnd} ) "
            + " group by a.id ";

        System.out.println(value);


    }

}
