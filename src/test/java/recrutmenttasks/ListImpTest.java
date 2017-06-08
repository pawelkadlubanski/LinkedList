package recrutmenttasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ListImpTest {

    private List <Integer>testedList;


    @Before
    public void createTestedList() {
        testedList = new ListImp<>();
    }

    @Test
    public void afterListIsCreatedItsSizeIsZero()  {
        Assert.assertEquals(0, testedList.size());
    }

    @Test
    public void afterOneElementIsAddedToListIsSizeIsOne()  {
        testedList.addElement(1);
        Assert.assertEquals(1, testedList.size());
    }

    @Test(expected = NegativeIndexException.class)
    public void shouldThrowExceptionWheTryToGetElementWithNegativeIndex()  {
        testedList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenTryToGetElementWithIndexHigherThenSize()  {
        testedList.get(1);
    }

    @Test()
    public void afterOneElementIsAddedTheSameElementShouldBeAbleToGet()  {
        Integer addedElement = new Integer(1);
        testedList.addElement(addedElement);
        Assert.assertEquals(addedElement, testedList.get(0));
    }

    @Test()
    public void afterTwoElementAreAddedTheShouldBeAbleToGetInTheSameOrder()  {
        Integer firstAddedElement = new Integer(9);
        Integer secondAddedElement = new Integer(11);
        testedList.addElement(firstAddedElement);
        testedList.addElement(secondAddedElement);
        Assert.assertEquals(firstAddedElement, testedList.get(0));
        Assert.assertEquals(secondAddedElement, testedList.get(1));
    }

    @Test()
    public void sortListWitOnlyOneElement()  {
        Integer firstAddedElement = new Integer(9);
        testedList.addElement(firstAddedElement);
        testedList.sort();
        Assert.assertEquals(firstAddedElement, testedList.get(0));
    }

    @Test()
    public void sortListWitTwoElementsAddedInAscendingOrder()  {
        Integer firstAddedElement = new Integer(9);
        Integer secondAddedElement = new Integer(11);
        testedList.addElement(firstAddedElement);
        testedList.addElement(secondAddedElement);
        int sizeOfListBeforeSort = testedList.size();
        testedList.sort();
        int sizeOfListAfterSort = testedList.size();
        Assert.assertEquals(firstAddedElement, testedList.get(0));
        Assert.assertEquals(secondAddedElement, testedList.get(1));
        Assert.assertEquals(sizeOfListAfterSort, sizeOfListBeforeSort);
    }

    @Test()
    public void sortListWithTwoElementsAddedInNotAscendingOrder()  {
        Integer firstAddedElement = new Integer(11);
        Integer secondAddedElement = new Integer(9);
        testedList.addElement(firstAddedElement);
        testedList.addElement(secondAddedElement);
        int sizeOfListBeforeSort = testedList.size();
        testedList.sort();
        int sizeOfListAfterSort = testedList.size();
        Assert.assertEquals(secondAddedElement, testedList.get(0));
        Assert.assertEquals(firstAddedElement, testedList.get(1));
        Assert.assertEquals(sizeOfListAfterSort, sizeOfListBeforeSort);
    }

    @Test()
    public void sortListWithThreeElementsAddedInNotAscendingOrder()  {
        Integer firstAddedElement = new Integer(11);
        Integer secondAddedElement = new Integer(9);
        Integer thirdAddedElement  =new Integer(10);
        testedList.addElement(firstAddedElement);
        testedList.addElement(secondAddedElement);
        testedList.addElement(thirdAddedElement);
        int sizeOfListBeforeSort = testedList.size();
        testedList.sort();
        int sizeOfListAfterSort = testedList.size();
        Assert.assertEquals(secondAddedElement, testedList.get(0));
        Assert.assertEquals(thirdAddedElement, testedList.get(1));
        Assert.assertEquals(firstAddedElement, testedList.get(2));
        Assert.assertEquals(sizeOfListAfterSort, sizeOfListBeforeSort);
    }
}