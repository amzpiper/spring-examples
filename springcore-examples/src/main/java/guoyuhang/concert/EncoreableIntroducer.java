package guoyuhang.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "top.guoyuhang.concert.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
