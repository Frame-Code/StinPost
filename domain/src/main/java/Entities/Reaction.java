package Entities;

import Enums.TypeReaction;
import ValueObjects.Reaction.ReactionId;
import ValueObjects.User.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Reaction {

    private final ReactionId reactionId;
    private final UserId userId;
    private final TypeReaction typeReaction;
}
