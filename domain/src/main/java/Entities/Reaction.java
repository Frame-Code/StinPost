package Entities;

import Enums.TypeReaction;
import ValueObjects.Reaction.ReactionId;
import ValueObjects.User.UserId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reaction {
    @EqualsAndHashCode.Include
    private final ReactionId reactionId;
    private final UserId userId;
    private final TypeReaction typeReaction;
}
