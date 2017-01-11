package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gojek.parkinglot.Commands;

public class CommandClassTest {

	Commands commands = new Commands();
    @Test
    public void checkCommandInList() throws Exception {
       
        assertTrue(commands.commandsMap.containsKey("create_parking_lot"));
        assertFalse(commands.commandsMap.containsKey("test"));
        assertFalse(commands.commandsMap.isEmpty());
    }

}
