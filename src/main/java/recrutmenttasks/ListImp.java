package recrutmenttasks;

public class ListImp <T extends Comparable<T>> implements List <T > {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public ListImp() {
        size = 0;
        head = null;
        tail = null;
    }

    public void addElement(T element) {
        if (head == null){
            addToHead(element);
        }
        else {
            addToTail(element);
        }
        size++;
    }

     public T get(int index) {
        checkIndexValue(index);
        return getElementForProperIndexValue(index);
    }

    public int size() {
        return size;
    }

    public void sort() {
        List<T> helpList = sortList(this);
        this.head = null;
        this.size = 0;
        for (int i = 0; i < helpList.size(); i++) {
            addElement(helpList.get(i));
        }
    }

    private void addToHead(T element) {
        head = new Node<>(element);
        tail = head;
    }

    private void addToTail(T element) {
        Node<T> newNode = new Node<>(element);
        Node<T> currentLastNode = tail;
        currentLastNode.setNext(newNode);
        tail = newNode;
    }

    private void checkIndexValue(int index) {
        if (index < 0)
            throw  new NegativeIndexException();
        if (index > size)
            throw new IndexOutOfBoundsException();
    }

    private T getElementForProperIndexValue(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }


    private List<T> sortList(List<T> unsortedList) {
        List<T> sortedList = new ListImp<>();
        if (unsortedList.size() == 1) {
            sortedList.addElement(unsortedList.get(0));
            return sortedList;
        }

        List<T> firstList = copyList(unsortedList, 0, unsortedList.size()/2);
        firstList = sortList(firstList);

        List<T> secondList = copyList(unsortedList, unsortedList.size()/2, unsortedList.size());
        secondList = sortList(secondList);

        sortedList = mergeListWithSorting(firstList, secondList);
        return sortedList;
    }

    private List<T> copyList(List<T> otherList, int startIndex, int endIndex) {
        List<T> firstList = new ListImp<>();
        for (int i = startIndex; i < endIndex; i++)
            firstList.addElement(otherList.get(i));
        return firstList;
    }

    private List<T> mergeListWithSorting(List<T> firstSortedList, List<T> secondSortedList) {
        List<T> mergedList = new ListImp<>();
        int firstListIndex = 0;
        int secondListIndex = 0;
        while (firstListIndex < firstSortedList.size() && secondListIndex < secondSortedList.size())
        {
            if (firstSortedList.get(firstListIndex).compareTo(secondSortedList.get(secondListIndex)) <0 ) {
                mergedList.addElement(firstSortedList.get(firstListIndex));
                firstListIndex++;
            } else {
                mergedList.addElement(secondSortedList.get(secondListIndex));
                secondListIndex++;
            }
        }

        for (int i = firstListIndex; i < firstSortedList.size(); i++)
            mergedList.addElement(firstSortedList.get(i));

        for (int i = secondListIndex; i < secondSortedList.size(); i++)
            mergedList.addElement(secondSortedList.get(i));

        return  mergedList;
    }

    private class Node<T extends Comparable<T>> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
