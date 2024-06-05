    import java.util.Collections;
    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.Comparator;

    class Students
    {
        String name, branch;
        int age,rollno;

        Students(String name, String branch, int age, int rollno)
        {
            this.name = name;
            this.branch = branch;
            this.age = age;
            this.rollno = rollno;
        }

        void PrintDetails(Students s1)
        {
            System.out.println("Name: " + s1.name + "\t" +
                            "Roll Number: " + s1.rollno + "\t" + 
                            "Branch: " + s1.branch + "\t" + 
                            "Age: " + s1.age);
        }

        String getName()
        {
            return name;
        }

        int getRoll()
        {
            return rollno;
        }

        String getBranch()
        {
            return branch;
        }

        int getAge()
        {
            return age;
        }
    }

    class StudentIterator implements Iterator<Students> 
    {
        private ArrayList<Students> studentList;
        private int index;

        public StudentIterator(ArrayList<Students> studentList) 
        {
            this.studentList = studentList;
            this.index = 0;
        }

        @Override
        public boolean hasNext() 
        {
            return index < studentList.size();
        }

        @Override
        public Students next() 
        {
            return studentList.get(index++);
        }
    }

    class StudentAgeComparator implements Comparator<Students>
    {
        @Override
        public int compare(Students s1, Students s2) 
        {
            return s1.getAge() - s2.getAge();
        }  
    }

    class StudentRollNoComparator implements Comparator<Students>
    {
        @Override
        public int compare(Students s1, Students s2) 
        {
            return s1.getRoll() - s2.getRoll();
        }
    }

    class StudentNameComparator implements Comparator<Students> {
        @Override
        public int compare(Students s1, Students s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }

    class StudentBranchComparator implements Comparator<Students> {
        @Override
        public int compare(Students s1, Students s2) {
            return s1.getBranch().compareTo(s2.getBranch());
        }
    }

    class Iterators
    {
        void IteratebyName(ArrayList<Students> studentList) 
        {
            Collections.sort(studentList, new StudentNameComparator());
            System.out.println("Sorted by Name:");
            StudentIterator iterator = new StudentIterator(studentList);
            while (iterator.hasNext()) 
            {
                Students student = iterator.next();
                student.PrintDetails(student);
                System.out.println();
            }
        }

        void IteratebyAge(ArrayList<Students> studentList) 
        {
            Collections.sort(studentList, new StudentAgeComparator());
            System.out.println("Sorted by Age:");
            StudentIterator iterator = new StudentIterator(studentList);
            while (iterator.hasNext()) 
            {
                Students student = iterator.next();
                student.PrintDetails(student);
                System.out.println();
            }
        }
        
        void IteratebyRoll(ArrayList<Students> studentList) 
        {
            Collections.sort(studentList, new StudentRollNoComparator());
            System.out.println("Sorted by Roll Number:");
            StudentIterator iterator = new StudentIterator(studentList);
            while (iterator.hasNext()) 
            {
                Students student = iterator.next();
                student.PrintDetails(student);
                System.out.println();
            }
        }
        
        void IteratebyBranch(ArrayList<Students> studentList) 
        {
            Collections.sort(studentList, new StudentBranchComparator());
            System.out.println("Sorted by Branch:");
            StudentIterator iterator = new StudentIterator(studentList);
            while (iterator.hasNext()) 
            {
                Students student = iterator.next();
                student.PrintDetails(student);
                System.out.println();
            }
        }
        
    }
    class client 
    {
        public static void main(String[] args) 
        {
            ArrayList<Students> studentList = new ArrayList<>();
            studentList.add(new Students("Alice", "Computer", 20, 103));
            studentList.add(new Students("Bob", "Mechanical", 22, 101));
            studentList.add(new Students("Charlie", "Aerospace", 21, 102));

            Iterators i = new Iterators();
            i.IteratebyName(studentList);
            i.IteratebyAge(studentList);
            i.IteratebyBranch(studentList);
            i.IteratebyRoll(studentList);
        }
    }
