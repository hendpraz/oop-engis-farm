/*
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
  
  T value;     

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
		
		~LinkedList() {
			if (!isEmpty()) 
			{
				Node<T>* pt = Head;
				Node<T>* ptDel;
				while(pt != NULL) 
				{
					ptDel = pt;
					pt = pt->NextNode;
					delete ptDel;
				}
			}
		};
		
		int find(T Elmnt) const 
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
		
		
		bool isEmpty() const 
		{
			return Head == NULL;
		};
		
		
		void add(T* Elmnt) 
		{
			if (isEmpty()) 
			{
				Head = new Node<T>(&Elmnt);
				Head->value = &Elmnt;
				Head->NextNode = NULL;
			} 
			else 
			{
				Node<T>* pt = Head;
				while(pt->NextNode != NULL)
				{
					pt = pt->NextNode;
				}
				
				Node<T>* pIns = new Node<T>(&Elmnt);
				pt->NextNode = pIns;
			}
		};
		
		
		void remove(T el) 
		{
			if (!isEmpty()) 
			{
				if (Head->value == el) 
				{ // elemen di awal
					if (Head->NextNode == NULL) 
					{ // elemen hanya 1
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
				// elemen yang ingin dihapus kemungkinan bukan di awal
				// cari elemen yang ingin dihapus
					Node<T>* fPt = Head;
					while (fPt->NextNode != NULL && fPt->value != el) 
					{
						fPt = fPt->NextNode ;
					}
				
					if (fPt->value == el) 
					{  
					// elemen ketemu
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
		
		T& get(int idx) const 
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
		
		
		int count() {
			int i = 0;
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
*/
