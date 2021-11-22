from typing import Set, Dict, Tuple, Iterable
from functools import reduce

#Recursive Descendant


class NonterminalNotDefined(Exception):
    pass

class SymbolNotDefined(Exception):
    pass

class Grammar:
    def __init__(self, N: Set[str], Sigma: Set[str], P: Dict[Tuple[str]], S: str) -> None:
        self.__n = N
        self.__sigma = Sigma
        self.__p = P
        self.__s = S

    @property
    def n(self):
        return self.__n

    @n.setter
    def n(self,new):
        self.__n = new

    @property
    def sigma(self):
        return self.__sigma

    @sigma.setter
    def sigma(self,new):
        self.__sigma = new

    @property
    def p(self):
        return self.__p
    
    @p.setter
    def p(self, new):
        self.__p = new

    def getNonTerminalString(self) -> str:
        return reduce(lambda x, y: x + ", " + y, self.__n,"")

    def getTerminalString(self) -> str:
        return reduce(lambda x,y: x + ", " + y, self.__sigma,"")


    @staticmethod
    def _singleProductionToString(prod: Iterable[str]) -> str:
        return reduce(lambda x,y: x + " " + y, prod,"")
    
    @staticmethod
    def _prodToString(productions: Tuple[Tuple[str], Set[Tuple[str]]]) -> str:
        res = productions[0]
        productionsAsStrings = map(Grammar._singleProductionToString, productions[1])
        return Grammar._singleProductionToString(res) + " -> " + reduce(lambda x,y: x + "|" + y if x!="" else y, productionsAsStrings, "")
    
    

