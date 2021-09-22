package configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {BeanConfPart1.class, BeanConfPart2.class})
public class BeanConfMaster {

}
