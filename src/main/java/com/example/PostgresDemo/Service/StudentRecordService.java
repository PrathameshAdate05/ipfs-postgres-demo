package com.example.PostgresDemo.Service;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.example.PostgresDemo.Config.IPFSConfig;
import com.example.PostgresDemo.Dao.StudentDao;
import com.example.PostgresDemo.Dao.StudentRecordDao;
import com.example.PostgresDemo.Entity.Student;
import com.example.PostgresDemo.Entity.StudentRecord;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.Multipart;
import io.ipfs.api.NamedStreamable;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.RandomAccess;

@Service
public class StudentRecordService implements StudentRecordServiceImpl{

    @Autowired
    StudentRecordDao studentRecordDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    IPFSConfig ipfsConfig;

    @Override
    public String insertFile(Student temp) {


        String filename = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(10), "ser");

        Student student = studentDao.save(temp);

        try {
            File file = new File("src/main/resources/tmp/"+filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            fileOutputStream.close();
            objectOutputStream.close();
            // adding file to ipfs

            IPFS ipfs  = ipfsConfig.ipfs;

            NamedStreamable.FileWrapper ipfsFile = new NamedStreamable.FileWrapper(file);
            MerkleNode res = ipfs.add(ipfsFile).get(0);

            StudentRecord studentRecord = new StudentRecord();
            studentRecord.setStudent_id(student.getRoll());
            studentRecord.setHash(res.hash.toBase58());

            studentRecordDao.save(studentRecord);

            return "Success" + res.hash.toBase58();
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Failed";
    }

    @Override
    public Student getStudentFromHash(String id) {
        return null;
    }
}
