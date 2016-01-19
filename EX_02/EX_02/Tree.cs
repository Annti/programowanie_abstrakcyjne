using System;
using System.Collections;
using System.Collections.Generic;

using EX_02;
using System.Collections.ObjectModel;



public class Tree<T> : IEnumerable<T>
{
    private EnumeratorOrder order;
    public EnumeratorOrder Order
    {
        get { return order; }
        set
        {
            if(!Enum.IsDefined(typeof(EnumeratorOrder), value))
            {
                throw new ArgumentOutOfRangeException();
            }
            order = value;
            foreach(var c in Children)
            {
                c.Order = value;
            }
        }
    }

    private T val;
    public T Value
    {
        get { return val; }
        set { val = value; }
    }
    
    private List<Tree<T>> children;
    public ReadOnlyCollection<Tree<T>> Children
    {
        get
        {
            return new ReadOnlyCollection<Tree<T>>(children.AsReadOnly());
        }
    }
    
    public Tree(T val, EnumeratorOrder order)
    {
        this.val = val;
        this.order = order;

        children = new List<Tree<T>>();
    }

    void BreadthFirstSearch(List<T> node)
    {
        foreach(var c in Children)
        {
            node.Add(c.Value);
        }
        foreach(var c in Children)
        {
            c.BreadthFirstSearch(node);
        }
    }

    void DepthFirstSearch(List<T> node)
    {
        node.Add(Value);
        foreach(var c in Children)
        {
            c.DepthFirstSearch(node);
        }
    }

    public void Add(T val)
    {
        Tree<T> t = new Tree<T>(val, Order);
        children.Add(t);
    }

    public void Add(Tree<T> subtree)
    {
        subtree.Order = Order;
        children.Add(subtree);
    }

    public IEnumerator<T> GetEnumerator()
    {
        var node = new List<T>();
        switch (Order)
        {
            case EnumeratorOrder.BreadthFirstSearch:
                node.Add(Value);
                BreadthFirstSearch(node);
                break;
            case EnumeratorOrder.DepthFirstSearch:
                DepthFirstSearch(node);
                break;
            //default:
                //return GetEnumerator();
        }

        ReadOnlyCollection<T> il = new ReadOnlyCollection<T>(node);
        foreach(var i in il)
        {
            yield return i;
        }
        
        //return retNode.AsReadOnly().GetEnumerator();
        //return node.GetEnumerator();
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }
}