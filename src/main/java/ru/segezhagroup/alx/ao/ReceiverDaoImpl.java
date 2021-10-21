package ru.segezhagroup.alx.ao;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.activeobjects.tx.Transactional;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import net.java.ao.DBParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class ReceiverDaoImpl implements ReceiverDao{

    @ComponentImport
    private final ActiveObjects ao;

    @Autowired
    public ReceiverDaoImpl(ActiveObjects ao) {
        this.ao = ao;
    }

    @Override
    public Receiver create(ReportTask reportTask, String userKey, String userEmail, String userName) {

//        final Receiver receiver = ao.create(Receiver.class,
//                new DBParam("USERKEY", userKey),
//                new DBParam("USEREMAIL", userEmail),
//                new DBParam("USERNAME", userName),
//                );

        final Receiver receiver = ao.create(Receiver.class);
        receiver.setReportTask(reportTask);
        receiver.setUserKey(userKey);
        receiver.setUserEmail(userEmail);
        receiver.setUserName(userName);
        receiver.save();

        return receiver;
    }

    @Override
    public void remove(Receiver receiver) {
        ao.delete(receiver);
    }
}
