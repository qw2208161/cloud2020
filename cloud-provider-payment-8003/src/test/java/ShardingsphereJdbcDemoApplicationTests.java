import com.jack.shardingspherejdbc.mapper.Course;
import com.jack.shardingspherejdbc.mapper.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zhqin.zhou
 * @date 2021/10/8 0:24
 * @description ShardingsphereJdbcDemoApplicationTests
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ShardingsphereJdbcDemoApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    //添加课程
    @Test
    public void addCourse() {
        Course course = new Course();
        //cid由我们设置的策略，雪花算法进行生成
        course.setCname("Java");
        course.setUserId(100L);
        course.setStatus("Normal");
        courseMapper.insert(course);
    }

}
