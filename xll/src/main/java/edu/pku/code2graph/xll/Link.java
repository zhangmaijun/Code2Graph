package edu.pku.code2graph.xll;

import edu.pku.code2graph.model.URI;

import java.util.Objects;

public final class Link {
  public final URI left;
  public final Rule rule;
  public final URI right;

  public Link(final URI left, final URI right) {
    this.left = left;
    this.rule = null;
    this.right = right;
  }

  public Link(final URI left, final URI right, final Rule rule) {
    this.left = left;
    this.rule = rule;
    this.right = right;
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("(");
    output.append(left.toString());
    output.append(", ");
    output.append(right.toString());
    output.append(")");
    return output.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Link link = (Link) o;
    return Objects.equals(left, link.left) && Objects.equals(right, link.right);
  }
}
