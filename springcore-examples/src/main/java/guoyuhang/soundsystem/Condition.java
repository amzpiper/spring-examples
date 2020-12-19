package guoyuhang.soundsystem;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public interface Condition {
    boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata);
}
