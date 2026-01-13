package Entities;

import Enums.TypeReaction;
import ValueObjects.Reaction.ReactionId;
import ValueObjects.User.UserId;

import java.util.Objects;

public class Reaction {
    private final ReactionId reactionId;
    private final UserId userId;
    private TypeReaction typeReaction;

    private Reaction(ReactionId reactionId, UserId userId, TypeReaction typeReaction) {
        if(reactionId == null) throw new IllegalArgumentException("El id de la reacción no puede ser nulo");
        if(userId == null) throw new IllegalArgumentException("El id del usuario no puede ser nulo");
        if(typeReaction == null) throw new IllegalArgumentException("El tipo de reacción no puede ser nulo");

        this.reactionId = reactionId;
        this.userId = userId;
        this.typeReaction = typeReaction;
    }

    public static Reaction create(ReactionId reactionId, UserId userId, TypeReaction typeReaction) {
        return new Reaction(reactionId, userId, typeReaction);
    }

    public static Reaction restore(ReactionId reactionId, UserId userId, TypeReaction typeReaction) {
        return new Reaction(reactionId, userId, typeReaction);
    }

    public void editTypeReaction(TypeReaction typeReaction) {
        if(typeReaction == null)
            throw new IllegalArgumentException("El tipo de reacción no puede ser nulo");
        this.typeReaction = typeReaction;
    }

    public ReactionId getReactionId() {
        return reactionId;
    }

    public UserId getUserId() {
        return userId;
    }

    public TypeReaction getTypeReaction() {
        return typeReaction;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reaction reaction = (Reaction) o;
        return Objects.equals(reactionId, reaction.reactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reactionId);
    }
}
