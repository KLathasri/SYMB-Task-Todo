package com.symb.task.todo.data;

import androidx.annotation.NonNull;

import com.symb.task.todo.common.Todo;
import com.symb.task.todo.common.TodosDao;

import java.util.ArrayList;
import java.util.List;


/*
* This is just for test purpose.
*
* */
public class TodosVolatileDao implements TodosDao {


    private static TodosVolatileDao mInstance;

    private static final List<Todo> TEST_TODO = new ArrayList<>();

    static {
        TEST_TODO.add(new TodoEntity("Volatile memory, in contrast to non-volatile memory, is computer memory that requires power to maintain the stored information; it retains its contents while powered on but when the power is interrupted, the stored data is quickly lost. ",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("Dynamic RAM (DRAM) is very popular due to its cost effectiveness. DRAM stores each bit of information in a different capacitor within the integrated circuit. DRAM chips need just one single capacitor and one transistor to store each bit of information. This makes it space efficient and inexpensive.[2] ",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("The catastrophic explosion at Beirut port on Tuesday evening (August 4) that has so far killed at least 100 people and injured around 4,000, with an unknown number feared trapped under rubble was, according to the government of Lebanon, caused by over 2,700 tonnes of ammonium nitrate kept in storage for over six years.",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("In India, The Ammonium Nitrate Rules, 2012, under The Explosives Act, 1884, define ammonium nitrate as the “compound with formula NH4NO3 including any mixture or compound having more than 45 per cent ammonium nitrate by weight including emulsions, suspensions, melts or gels but excluding emulsion or slurry explosives and non explosives emulsion matrix and fertilizers from which the ammonium nitrate cannot be separated”.",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("One is by some type detonation or initiation because the storage comes in contact with explosive mixture. Second, the blast can result due to a fire which starts in the ammonium nitrate store because of the heat generated due to the oxidation process at large scale. The second one seems to be the primary likely cause of the incident at Beirut port. There are several documented examples of deadly ammonium nitrate fire and explosion incidents in the past, some with large numbers of fatalities like in China in 2015 and in Texas in 1947.",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("\n" +
                "\n" +
                "For the manufacture of ammonium nitrate, an Industrial licence is required under the Industrial Development and Regulation Act, 1951. A license under the Ammonium Nitrate Rules, 2012 is also required for any activity related to ammonium nitrate.",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("Delhi High Court has asked Delhi University to ensure that no visually impaired student is deprived of a scribe at common service centres if the student has opted for one. The HC has granted one week's time to visually impaired students for getting the study material from Delhi University, DU. The Court has further directed the varsity to provide the books to the visually impaired students within three weeks from the time they have requested for it. The Delhi University Open Book Exams is scheduled to begin on August 10, 2020 and Delhi HC has postponed the hearing till August 17, 2020. ",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("Recently as per the UGC guidelines, the University final year exams can be conducted in online, offline or blended mode but before September 30, 2020. In the previous hearing, the court was informed about many other varsities that had already conducted exams and were on the verge of delivering results. Court then directed to confirm the details on downloading the question paper from email, uploading answer on email. Court also wished to know where the email of colleges/helplines was published, what were the decisions on the grievances committee and if the size of the copy could be increased beyond 5 MB. High Court also asked the varsity to give the range of the marks for the course and examination shifts.",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("The remarks from the former Congress chief comes with the party initially being circumspect on entering the ‘bhoomi pujan’ discourse. A statement from the Gandhi family came only day before the event, with Priyanka Gandhi Vadra calling the groundbreaking ceremony a “marker” of national unity, brotherhood, and cultural harmony. (Ayodhya Ram Mandir Bhumi Pujan: Follow LIVE updates here)",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("Congress leader and Rajasthan Chief Minister Ashok Gehlot also said that Lord Ram teaches us the importance of truth, justice, equality of all. “Lord Ram holds a unique place in our culture and civilization. His life teaches us the importance of truth, justice, equality of all, compassion & brotherhood. We need to focus on establishing an egalitarian society based on the values espoused by Lord Ram,” he said in a tweet.",
                System.currentTimeMillis()));
        TEST_TODO.add(new TodoEntity("West Bengal Chief Minister and TMC supremo Mamata Banerjee said, “Hindu Muslim Sikh Isaai, Aapas mein hain Bhai Bhai! Mera Bharat Mahaan, Mahaan Hamara Hindustan.” “Our country has always upheld the age-old legacy of unity in diversity, and we must preserve this to our last breath,” she tweeted.",
                System.currentTimeMillis()));
    }


    private TodosVolatileDao() {

    }

    static TodosVolatileDao getInstance() {
        if (mInstance == null) {
            mInstance = new TodosVolatileDao();
        }
        return mInstance;
    }

    @Override
    public boolean saveTodo(Todo todoToSave) {
        TEST_TODO.add(todoToSave);
        return true;
    }

    @Override
    @NonNull
    public List<Todo> getSavedTodos() {
        return TEST_TODO;
    }

    @Override
    public void closeDao() {
        TEST_TODO.clear();
    }
}
