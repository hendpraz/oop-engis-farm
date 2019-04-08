#ifndef linked_list_H
#define linked_list_H

#include <iostream>

template <class T>
struct Node {
  Node(T value) : value(value), NextNode(NULL) 
  {
  
  }
  
  Node() : NextNode(NULL)
  {
  	
  }
  
  T* value;     

  Node<T> *NextNode;   
  
};


template <class T>
class LinkedList {
		
	private:
		Node<T>* Head; 
	
	public:
		LinkedList() 
		{
			Head = NULL;
		};
		
		bool isEmpty() const 
		{
			return Head == NULL;
		};
		
		int find(T* Elmnt) const 
		{
			if (!isEmpty()) 
			{
				int i = 0;
				Node<T>* pt = Head;
				while (pt->NextNode != NULL && pt->value != Elmnt) 
				{
					pt = pt->NextNode;
					i++;
				}
				
				if (pt->value == Elmnt) 
				{
					return i;
				}
			
			}
			return -1;
		};
		
		
		void add(T* Elmnt) 
		{
			if (isEmpty()) 
			{
				Head = new Node<T>;
				Head->value = Elmnt;
				Head->NextNode = NULL;
			}
			else 
			{
				Node<T>* pt = Head;
				while(pt->NextNode != NULL)
				{
					pt = pt->NextNode;
				}
				
				Node<T>* pIns = new Node<T>();	
				pIns->value = Elmnt;
				pt->NextNode = pIns;
			}
			
		
		};
		
		
		
		T* get(int idx) 
		{
			if (idx >= 0 && !isEmpty()) 
			{
				int i = 0;
				Node<T>* pt = Head;
				while (i < idx && pt != NULL)
				{
					pt = pt->NextNode;
					i++;
				}
				if (i == idx && pt != NULL) 
				{
					return pt->value;
				} 
			}
			return NULL ;
		};
		
		void remove(T* el) 
		{
			if (!isEmpty()) 
			{
				if (Head->value == el) 
				{ 
					if (Head->NextNode == NULL) 
					{ 
						delete Head;
						Head = NULL;
					} 
					else 
					{
						Node<T>* delPt = Head;
						Head = Head->NextNode;
						delete delPt;
					}
				}
				else 
				{  
					Node<T>* fPt = Head;
					while (fPt->NextNode != NULL && fPt->value != el) 
					{
						fPt = fPt->NextNode ;
					}
				
					if (fPt->value == el) 
					{  
						Node<T>* befPt = Head;
						while (befPt->NextNode != fPt) 
						{
							befPt = befPt->NextNode;
						}
						befPt->NextNode = fPt->NextNode;		
						delete fPt;
					}
				}
			}
		};
		
		int count() {
			int i = 1;
			if (Head != NULL) 
			{				
				Node<T>* pt = Head;
				while (pt->NextNode != NULL) 
				{
					pt = pt->NextNode;
					i++;
				}		
			}
			return i;
		};
		


};
#endif
