package dom.todo;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QToDoItem extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<ToDoItem> implements PersistableExpression<ToDoItem>
{
    public static final QToDoItem jdoCandidate = candidate("this");

    public static QToDoItem candidate(String name)
    {
        return new QToDoItem(null, name, 5);
    }

    public static QToDoItem candidate()
    {
        return jdoCandidate;
    }

    public static QToDoItem parameter(String name)
    {
        return new QToDoItem(ToDoItem.class, name, ExpressionType.PARAMETER);
    }

    public static QToDoItem variable(String name)
    {
        return new QToDoItem(ToDoItem.class, name, ExpressionType.VARIABLE);
    }

    public final ObjectExpression<org.slf4j.Logger> LOG;
    public final StringExpression description;
    public final ObjectExpression<org.joda.time.LocalDate> dueBy;
    public final ObjectExpression<dom.todo.ToDoItem.Category> category;
    public final ObjectExpression<dom.todo.ToDoItem.Subcategory> subcategory;
    public final StringExpression ownedBy;
    public final BooleanExpression complete;
    public final ObjectExpression<java.math.BigDecimal> cost;
    public final StringExpression notes;
    public final ObjectExpression<org.apache.isis.applib.value.Blob> attachment;
    public final CollectionExpression dependencies;
    public final NumericExpression<Long> ONE_WEEK_IN_MILLIS;
    public final ObjectExpression<org.apache.isis.applib.DomainObjectContainer> container;
    public final ObjectExpression<dom.todo.ToDoItems> toDoItems;
    public final ObjectExpression<org.apache.isis.applib.services.clock.ClockService> clockService;
    public final ObjectExpression<org.apache.isis.applib.annotation.Bulk.InteractionContext> bulkInteractionContext;
    public final ObjectExpression<org.apache.isis.applib.services.command.CommandContext> commandContext;
    public final ObjectExpression<org.apache.isis.applib.services.background.BackgroundService> backgroundService;
    public final ObjectExpression<org.apache.isis.applib.services.scratchpad.Scratchpad> scratchpad;

    public QToDoItem(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.LOG = new ObjectExpressionImpl<org.slf4j.Logger>(this, "LOG");
        this.description = new StringExpressionImpl(this, "description");
        this.dueBy = new ObjectExpressionImpl<org.joda.time.LocalDate>(this, "dueBy");
        this.category = new ObjectExpressionImpl<dom.todo.ToDoItem.Category>(this, "category");
        this.subcategory = new ObjectExpressionImpl<dom.todo.ToDoItem.Subcategory>(this, "subcategory");
        this.ownedBy = new StringExpressionImpl(this, "ownedBy");
        this.complete = new BooleanExpressionImpl(this, "complete");
        this.cost = new ObjectExpressionImpl<java.math.BigDecimal>(this, "cost");
        this.notes = new StringExpressionImpl(this, "notes");
        this.attachment = new ObjectExpressionImpl<org.apache.isis.applib.value.Blob>(this, "attachment");
        this.dependencies = new CollectionExpressionImpl(this, "dependencies");
        this.ONE_WEEK_IN_MILLIS = new NumericExpressionImpl<Long>(this, "ONE_WEEK_IN_MILLIS");
        this.container = new ObjectExpressionImpl<org.apache.isis.applib.DomainObjectContainer>(this, "container");
        this.toDoItems = new ObjectExpressionImpl<dom.todo.ToDoItems>(this, "toDoItems");
        this.clockService = new ObjectExpressionImpl<org.apache.isis.applib.services.clock.ClockService>(this, "clockService");
        this.bulkInteractionContext = new ObjectExpressionImpl<org.apache.isis.applib.annotation.Bulk.InteractionContext>(this, "bulkInteractionContext");
        this.commandContext = new ObjectExpressionImpl<org.apache.isis.applib.services.command.CommandContext>(this, "commandContext");
        this.backgroundService = new ObjectExpressionImpl<org.apache.isis.applib.services.background.BackgroundService>(this, "backgroundService");
        this.scratchpad = new ObjectExpressionImpl<org.apache.isis.applib.services.scratchpad.Scratchpad>(this, "scratchpad");
    }

    public QToDoItem(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.LOG = new ObjectExpressionImpl<org.slf4j.Logger>(this, "LOG");
        this.description = new StringExpressionImpl(this, "description");
        this.dueBy = new ObjectExpressionImpl<org.joda.time.LocalDate>(this, "dueBy");
        this.category = new ObjectExpressionImpl<dom.todo.ToDoItem.Category>(this, "category");
        this.subcategory = new ObjectExpressionImpl<dom.todo.ToDoItem.Subcategory>(this, "subcategory");
        this.ownedBy = new StringExpressionImpl(this, "ownedBy");
        this.complete = new BooleanExpressionImpl(this, "complete");
        this.cost = new ObjectExpressionImpl<java.math.BigDecimal>(this, "cost");
        this.notes = new StringExpressionImpl(this, "notes");
        this.attachment = new ObjectExpressionImpl<org.apache.isis.applib.value.Blob>(this, "attachment");
        this.dependencies = new CollectionExpressionImpl(this, "dependencies");
        this.ONE_WEEK_IN_MILLIS = new NumericExpressionImpl<Long>(this, "ONE_WEEK_IN_MILLIS");
        this.container = new ObjectExpressionImpl<org.apache.isis.applib.DomainObjectContainer>(this, "container");
        this.toDoItems = new ObjectExpressionImpl<dom.todo.ToDoItems>(this, "toDoItems");
        this.clockService = new ObjectExpressionImpl<org.apache.isis.applib.services.clock.ClockService>(this, "clockService");
        this.bulkInteractionContext = new ObjectExpressionImpl<org.apache.isis.applib.annotation.Bulk.InteractionContext>(this, "bulkInteractionContext");
        this.commandContext = new ObjectExpressionImpl<org.apache.isis.applib.services.command.CommandContext>(this, "commandContext");
        this.backgroundService = new ObjectExpressionImpl<org.apache.isis.applib.services.background.BackgroundService>(this, "backgroundService");
        this.scratchpad = new ObjectExpressionImpl<org.apache.isis.applib.services.scratchpad.Scratchpad>(this, "scratchpad");
    }
}
