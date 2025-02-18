import pytest

@pytest.fixture
def balance():
    amount = 0
    return amount

@pytest.mark.parametrize("earned,spent,expected" , [(30,10,20), (20,2,18), ])
def testBalance (balance,earned,spent,expected):
    balance+=earned
    balanced-=spent
    assert balance == expected

